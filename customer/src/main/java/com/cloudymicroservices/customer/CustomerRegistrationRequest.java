package com.cloudymicroservices.customer;

public record CustomerRegistrationRequest(String firstName, String lastName, String email) {
}
