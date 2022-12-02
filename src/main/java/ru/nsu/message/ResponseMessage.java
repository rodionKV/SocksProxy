package ru.nsu.message;

import java.util.Arrays;

public class ResponseMessage extends Message {
    private final RequestMessage request;

    public ResponseMessage(RequestMessage request)
    {
        super(Arrays.copyOf(request.getData(), request.getData().length));
        this.request = request;
    }

    public byte[] create(boolean isConnected)
    {
        data[0] = SOCKS_5;
        data[1] = SUCCEEDED;
        if (request.isCommand(CONNECT_TCP))
            data[1] = COMMAND_NOT_SUPPORTED;

        if (!isConnected)
            data[1] = HOST_NOT_AVAILABLE;

        if (request.getAddressType() == IPv6)
            data[1] = ADDRESS_TYPE_NOT_SUPPORTED;

        return data;
    }
}