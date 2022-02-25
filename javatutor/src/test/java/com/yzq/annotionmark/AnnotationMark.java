package com.yzq.annotionmark;

/**
 * @author yanni
 * @author yzq
 * @date time 2021/11/8 10:41
 * @apiNote 这是一个note
 * @since jdk17
 */
public class AnnotationMark extends Human implements People {
    /**
     * 这里要说话
     *
     * @param str 说的话
     * @since 1.8
     */
    void say(String str) {
        System.out.println(str);

    }

    /**
     * 用户名
     *
     * @param id 用户id
     * @return 用户名id
     * @since 16 April 2001
     */
    @Override
    public String username(String id) {
        return id + "id";
    }

    /**
     * <p>{@link People#say()} 人说话</p>
     * {@link Human#name} 人类名字<br>
     * 可不用顶头写 {@link People#eat(String)}<br>
     * {@link com.yzq.entity.charactor.Hero#name} 英雄名字<br>
     * <p>使用@see时应注意 顶头写</p>
     *
     * @see com.yzq.entity.charactor.Hero#name
     * @see Human#name
     */
    void getName() {

    }

    /**
     * {@link People#say()} 人类说
     * <p>可以使用html链接</p>
     * 这是code {@code String}
     * @see <a href="https://www.runoob.com/java/java8-default-methods.html">java默认方法</a>
     */
    @Override
    public void say() {

    }

    /**
     * 长代码例子
     * <p><pre class="code">
     * StringUtils.hasText(null) = false
     * StringUtils.hasText("") = false
     * StringUtils.hasText(" ") = false
     * StringUtils.hasText("12345") = true
     * StringUtils.hasText(" 12345 ") = true
     * </pre>
     *
     * @param str the {@code CharSequence} to check (may be {@code null})
     * @return {@code true} if the {@code CharSequence} is not {@code null},
     * its length is greater than 0, and it does not contain whitespace only
     * @see Character#isWhitespace
     */
    @Override
    public Boolean eat(String str) {
        return true;
    }

    /**
     * @throws IllegalArgumentException
     * @apiNote 这是个api
     * @implNote 解释api
     * @implSpec 哈哈哈
     * @deprecated 已经启用
     */
    @Deprecated
    void apiTest() throws IllegalArgumentException {

    }
}
