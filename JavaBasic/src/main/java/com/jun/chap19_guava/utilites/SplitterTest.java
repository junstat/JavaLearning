package com.jun.chap19_guava.utilites;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class SplitterTest {
    @Test
    public void testSplitOnSplit() {
        List<String> result = Splitter.on("|").splitToList("Hello|world");
        // System.out.println(result);
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0), equalTo("Hello"));
        assertThat(result.get(1), equalTo("world"));
    }

    @Test
    public void testSplit_On_Split_OmitEmpty() {
        List<String> result = Splitter.on("|").omitEmptyStrings().splitToList("Hello|world|||");
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0), equalTo("Hello"));
        assertThat(result.get(1), equalTo("world"));
    }

    @Test
    public void testSplit_On_Split_OmitEmpty_TrimResult() {
        List<String> result = Splitter.on("|").trimResults().omitEmptyStrings().splitToList("Hello   | world   |||");
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0), equalTo("Hello"));
        assertThat(result.get(1), equalTo("world"));
    }

    @Test
    public void testSplitFixLength() {
        List<String> result = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");
        // System.out.println(result);
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(4));
        assertThat(result.get(0), equalTo("aaaa"));
        assertThat(result.get(1), equalTo("bbbb"));
        assertThat(result.get(2), equalTo("cccc"));
        assertThat(result.get(3), equalTo("dddd"));
    }

    @Test
    public void testSplitOnSplitLimit() {
        List<String> result = Splitter.on('#').limit(3).splitToList("hello#world#scala#java");
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(3));
        assertThat(result.get(0), equalTo("hello"));
        assertThat(result.get(2), equalTo("scala#java"));

    }

    @Test
    public void testSplitOnPatternString() {
        List<String> result = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("hello  || world ||   |");
        // System.out.println(result);
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0), equalTo("hello"));
        assertThat(result.get(1), equalTo("world"));
    }

    @Test
    public void testSplitOnPattern() {
        List<String> result = Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().splitToList("hello  || world ||   |");
        // System.out.println(result);
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0), equalTo("hello"));
        assertThat(result.get(1), equalTo("world"));
    }


    @Test
    public void testSplitOnSplitToMap() {
        Map<String, String> result = Splitter.on(Pattern.compile("\\|"))
                .trimResults().omitEmptyStrings()
                .withKeyValueSeparator("=")
                .split("hello=HELLO|| world=WORLD |  | ");
        // System.out.println(result);
        assertThat(result, notNullValue());
        assertThat(result.size(), equalTo(2));
        assertThat(result.get("hello"), equalTo("HELLO"));
        assertThat(result.get("world"), equalTo("WORLD"));
    }

}
