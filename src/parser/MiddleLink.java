package parser;

import java.util.ArrayList;

public abstract class MiddleLink {
    protected MiddleLink next;
    public abstract ArrayList<String> parse(ArrayList<String> text);
    public MiddleLink linkedWith(MiddleLink next)
    {
        this.next=next;
        return next;
    }
    public ArrayList<String> parseNext(ArrayList<String> text)
    {
        if(next!=null)
        {
            return this.next.parse(text);
        } else
        {
            return text;
        }
    }
}
