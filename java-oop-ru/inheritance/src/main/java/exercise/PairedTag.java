package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String content;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String content, List<Tag> children) {
        super(tagName, attributes);
        this.content = content;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        if (!content.isEmpty()) {
            result.append(content);
        } else {
            for (Tag child : children) {
                result.append(child.toString());
            }
        }
        result.append("</").append(tagName).append(">");
        return result.toString();
    }
}
// END
