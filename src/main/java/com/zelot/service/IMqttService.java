package com.zelot.service;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface IMqttService {

    public void init() throws MqttException;

    public void submit(String topic) throws MqttException;

    public void publish(String topic,String msg) throws MqttException;
}
