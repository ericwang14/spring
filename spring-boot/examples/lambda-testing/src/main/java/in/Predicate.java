package in;

/**
 * Created by wanggang on 10/20/16.
 */


@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);


    default T apply(T t) {
        return t;
    };
}
