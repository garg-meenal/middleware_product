package com.middleware.product.service.impl;

import org.springframework.stereotype.Service;

import com.middleware.order.proto.Order.OrderRequest;
import com.middleware.order.proto.Order.OrderResponse;
import com.middleware.order.proto.OrderServiceGrpc;
import com.middleware.order.proto.OrderServiceGrpc.OrderServiceBlockingStub;
import com.middleware.product.model.Product;
import com.middleware.product.service.ProductService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public String createProduct(Product product) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8083)
		          .usePlaintext()
		          .build();
		OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);
		OrderResponse orderResponse = stub
				.placeOrder(OrderRequest.newBuilder()
				.setProductId(product.getId())
				.setProductName(product.getName())
				.setProductColor(product.getColor())
				.setProductDescription(product.getDescription())
				.setProductPrice(product.getPrice())
				.build());

		channel.shutdown();
		return orderResponse.getMessage();
	}

	@Override
	public String updateProduct(Product product) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8083)
		          .usePlaintext()
		          .build();
		OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);
		OrderResponse orderResponse = stub
				.updateOrder(OrderRequest.newBuilder()
				.setProductId(product.getId())
				.setProductName(product.getName())
				.setProductColor(product.getColor())
				.setProductDescription(product.getDescription())
				.setProductPrice(product.getPrice())
				.build());

		channel.shutdown();
		return orderResponse.getMessage();
	}

}
