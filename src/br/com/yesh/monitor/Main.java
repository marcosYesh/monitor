package br.com.yesh.monitor;

import br.com.yesh.monitor.jdbc.Register;

public class Main {

	public static void main(String[] args) {
		Boolean ativo = true;
		while (true) {
			try {
				if (TestePing.TesteConect()) {
					if (ativo == false) {
						ativo = true;
						Register.setActive(true);
					}
				} else {
					if (ativo == true) {
						ativo = false;
						Register.setActive(false);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.toString());
			}
		}

	}

}
