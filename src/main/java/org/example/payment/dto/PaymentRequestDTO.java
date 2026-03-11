package org.example.payment.dto;

import org.example.payment.model.ServiceType;

public class PaymentRequestDTO {
    private String codigoCliente;
    private ServiceType serviceType;
    private Double deuda;

    public String getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(String codigoCliente) { this.codigoCliente = codigoCliente; }

    public ServiceType getServiceType() { return serviceType; }
    public void setServiceType(ServiceType serviceType) { this.serviceType = serviceType; }

    public Double getDeuda() { return deuda; }
    public void setDeuda(Double deuda) { this.deuda = deuda; }
}
