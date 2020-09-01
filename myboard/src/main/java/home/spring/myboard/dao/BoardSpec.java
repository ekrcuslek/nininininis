package home.spring.myboard.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import home.spring.myboard.domain.BoardVO;

public class BoardSpec {
	// 컨텐츠에 특정 키워드가 들어가 있는지 찾는 조건
	public static Specification<BoardVO> searchKeyword(Map<String, Object> filter) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<>();
			filter.forEach((key, value) -> {
				switch (key) {
				case "content":
					predicates.add(builder.like(root.get(key).as(String.class), "%" + value + "%"));
					break;
				case "userId":
					predicates.add(builder.equal(root.get(key).as(String.class), value));
					break;
				case "title":
					predicates.add(builder.like(root.get(key).as(String.class), "%" + value + "%"));
				}
			});
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
