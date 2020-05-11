package com.zelot.dao;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import com.zelot.ModelDo.Contants;

public class MqttClientTest {

    private static final String HOST = "tcp://127.0.0.1:1883";
    private static final String CLIENTID ="client2"; //客户端唯一标识
    private static final String USERNAME ="test";
    private static final String PASSWORD = "123456";

    private  static final String DEV_NO = "SL_8813255";

    private MqttClient mqttClient;

    public void connect()throws MqttException{
        mqttClient = new MqttClient(HOST,CLIENTID,new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());
        options.setConnectionTimeout(100);
        options.setKeepAliveInterval(180);
        options.setAutomaticReconnect(true);
        options.setWill(DEV_NO+ Contants.MOTT_UP,"offline".getBytes(),0,true);

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

    public void submit(String topic) throws MqttException{
        mqttClient.subscribe(topic, 2);  //qos 服务质量 123
    }

    public void publish(String topic,String msg) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(0);
        mqttMessage.setPayload(msg.getBytes());
        MqttTopic mqttTopic = mqttClient.getTopic(topic);
        MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
        token.waitForCompletion();
    }

    public static void main(String[] args) throws MqttException {
        MqttClientTest mqttClientTest = new MqttClientTest();
        mqttClientTest.connect();
        String topic = DEV_NO+ Contants.MOTT_UP;
        //mqttClientTest.submit(topic);
        mqttClientTest.publish(topic,"测试消息");
    }
}
