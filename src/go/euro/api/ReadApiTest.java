package go.euro.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReadApiTest {

	@Test
	public void testValidateInputString() {
		assertEquals(false,ReadApi.ValidateInputString(""));
		assertEquals(false,ReadApi.ValidateInputString(" "));
		assertEquals(false,ReadApi.ValidateInputString("123"));
		assertEquals(true,ReadApi.ValidateInputString("Berlin"));
		assertEquals(false,ReadApi.ValidateInputString(" Berlin"));
		assertEquals(true,ReadApi.ValidateInputString("Ber-lin"));
		assertEquals(false,ReadApi.ValidateInputString("Ber--lin"));
		assertEquals(true,ReadApi.ValidateInputString("San Fransisco"));
		assertEquals(true,ReadApi.ValidateInputString("Île-de-France"));
	}

}
