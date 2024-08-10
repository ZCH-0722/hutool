package org.dromara.hutool.json.engine;

import org.dromara.hutool.core.text.StrUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JacksonTest {
	/**
	 * jackson默认缩进两个空格，使用\r\n换行符
	 */
	@Test
	void prettyPrintTest() {
		final JSONEngine engine = JSONEngineFactory.createEngine("jackson");
		engine.init(JSONEngineConfig.of().setPrettyPrint(true));

		final JSONEngineFactoryTest.TestBean testBean = new JSONEngineFactoryTest.TestBean("张三", 18, true);
		String jsonString = engine.toJsonString(testBean);
		// 使用统一换行符
		jsonString = StrUtil.removeAll(jsonString, '\r');
		Assertions.assertEquals("{\n" +
			"  \"name\" : \"张三\",\n" +
			"  \"age\" : 18,\n" +
			"  \"gender\" : true\n" +
			"}", jsonString);
	}
}
