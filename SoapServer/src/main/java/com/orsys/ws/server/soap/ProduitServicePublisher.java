package com.orsys.ws.server.soap;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.Endpoint;


public class ProduitServicePublisher {

    public static void main(String[] args) throws JAXBException {
        Endpoint endpoint = Endpoint.create(new ProduitServiceImpl());
        endpoint.publish("http://localhost:8888/ws/produits");

    }
}
