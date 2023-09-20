package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface childTag;

    public LabelTag(String text, TagInterface childTag) {
        this.text = text;
        this.childTag = childTag;
    }

    @Override
    public String render() {
        String childRendered = childTag.render();
        return String.format("<label>%s%s</label>", text, childRendered);
    }
}
// END
