package ru.nsu.message;

import lombok.Getter;

public abstract class Message {
    public static final byte SOCKS_5 = 0x05;

    public static final byte IPv4 = (byte) 0x01;
    public static final byte IPv6 = (byte) 0x04;

    public static final byte DOMAIN_NAME = (byte) 0x03;

    public static final byte COMMAND_NOT_SUPPORTED = 0x07;
    public static final byte ADDRESS_TYPE_NOT_SUPPORTED = 0x08;
    public static final byte SUCCEEDED = 0x00;
    public static final byte HOST_NOT_AVAILABLE = 0x04;
    public static final byte NO_AUTHENTICATION = 0x00;
    public static final byte NO_ACCEPTABLE_METHODS = (byte) 0xFF;
    public static final byte CONNECT_TCP = (byte) 0x01;

    @Getter
    byte[] data;

    Message(byte[] buff)
    {
        data = buff;
    }

    static byte getCurrentMethod()
    {
        return  NO_AUTHENTICATION;
    }
}
