package com.oliver.shopSpring.entity.enums;

public enum OrderStatus {
	
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int code;

	private OrderStatus(int i) {
		this.code = i;
	}

	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		
		for(OrderStatus valor : OrderStatus.values()) {
			if(valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Invalido o codigo do status!");
	}
	
	

}
