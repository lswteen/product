package kr.co.renzo.core.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtils {

    public static <T,S> T toObject(S source, Class<T> targetClass, String... ignoreProperties) {
        T target = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(source, target, ignoreProperties);

        return target;
    }

    public static <T, S> List<T> toList(List<S> sources, Class<T> targetClass, String... ignoreProperties) {
        return sources.stream()
                .map(source -> toObject(source, targetClass, ignoreProperties))
                .collect(Collectors.toList());
    }

    public static <T, S> Page<T> toPage(Page<S> sources, Class<T> targetClass, String... ignoreProperties) {
        List<T> targets = sources.getContent().stream()
                .map(source -> toObject(source, targetClass, ignoreProperties))
                .collect(Collectors.toList());

        return new PageImpl<>(targets, sources.getPageable(), targets.size());
    }
}

