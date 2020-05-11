package com.zelot.service;

import com.zelot.ModelDo.Contants;
import com.zelot.ModelDo.Device;
import com.zelot.dao.DeviceDao;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMqttServiceImp implements IMqttService, InitializingBean {

    @Value(value = "${mqtt.host}")
    private String host;
    @Value(value = "${mqtt.client}")
    private String clientId;
    @Value(value = "${mqtt.username}")
    private String username;
    @Value(value = "${mqtt.password}")
    private String password;

    private MqttClient mqttClient;

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public void init() throws MqttException {
        connect();
        List<Device> devices = deviceDao.selectAll();
        for(Device device : devices){
            submit(device.getDevNo() + Contants.MOTT_UP);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void connect()throws MqttException{
        mqttClient = new MqttClient(host,clientId,new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(100);
        options.setKeepAliveInterval(180);
        options.setAutomaticReconnect(true);

        mqttClient.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("连接断开，可以做处理");
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("topic: "+topic);
                System.out.println("message: "+message);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("发送成功后回调");
            }
        });
        mqttClient.connect(options);
        System.out.println("连接成功");
    }

    @Override
    public void submit(String topic) throws MqttException {
        mqttClient.subscribe(topic,2);
    }

    @Override
    public void publish(String topic, String msg) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(2);
        mqttMessage.setPayload(msg.getBytes());
        MqttTopic mqttTopic = mqttClient.getTopic(topic);
        MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
        token.waitForCompletion();
    }
}
