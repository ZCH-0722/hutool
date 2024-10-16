package cn.hutool.core.collection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * {@link FilterIter} 单元测试
 * @author chao.wang
 */
public class FilterIterTest {

	@Test
	public void checkFilterIter() {
		Iterator<String> it = ListUtil.of("1", "2").iterator();
		// filter 为null
		FilterIter<String> filterIter = new FilterIter<>(it, null);

		int count = 0;
		while (filterIter.hasNext()) {
			if(filterIter.next() != null){
				count++;
			}
		}
		assertEquals(2, count);

		it = ListUtil.of("1", "2").iterator();
		// filter 不为空
		filterIter = new FilterIter<>(it, (key) -> key.equals("1"));
		count = 0;
		while (filterIter.hasNext()) {
			if(filterIter.next() != null){
				count++;
			}
		}
		assertEquals(1, count);
	}

}
