package com.portfolio.calculateeNetworth.util;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MutualFundIdGenerator implements IdentifierGenerator {

	private static final String numbers = "1234567890";
	private static final Random random = new Random();

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return generateRandom();
	}

	private String generateRandom() {
		int i = 19;
		String uid = "M";
		while (i-- > 0) {
			uid += numbers.charAt(random.nextInt(10));
		}

		return uid;
	}

}