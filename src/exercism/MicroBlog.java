package exercism;

class MicroBlog {
    public String truncate(String input) {
        StringBuilder truncatedInput = new StringBuilder();
        input.codePoints()
                .limit(5)
                .forEach(i -> truncatedInput.appendCodePoint(i));
        return truncatedInput.toString();
    }
}

