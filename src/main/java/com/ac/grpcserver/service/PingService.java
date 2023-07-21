package com.ac.grpcserver.service;

import com.ac.grpcserver.grpc.PingData;
import com.ac.grpcserver.grpc.PingRequest;
import com.ac.grpcserver.grpc.PingResponse;
import com.google.protobuf.StringValue;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class PingService {

    public PingResponse ping(PingRequest request) throws UnknownHostException {
        PingResponse.Builder builder = PingResponse.newBuilder();

        InetAddress IP = InetAddress.getLocalHost();

        PingData data = PingData.newBuilder()
                .setIp(IP.getHostAddress())
                .setMessage(StringValue.newBuilder()
                        .setValue(request.getMessage())
                        .build())
                .build();
        builder.setData(data);
        builder.setCode(200);

        return builder.build();
    }
}
