package com.ac.grpcserver.grpc.impl;

import com.ac.grpcserver.grpc.PingRequest;
import com.ac.grpcserver.grpc.PingResponse;
import com.ac.grpcserver.grpc.PingServiceGrpc;
import com.ac.grpcserver.service.PingService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
@GrpcService
public class PingPongGrpcService extends PingServiceGrpc.PingServiceImplBase {

    @Autowired
    protected PingService pingService;
    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {

        try {
            responseObserver.onNext(pingService.ping(request));
            responseObserver.onCompleted();
        }catch (Exception e){

            PingResponse response = PingResponse.newBuilder().setCode(500).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }
    }
}
