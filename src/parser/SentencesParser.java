package parser;

import java.util.ArrayList;

public class SentencesParser extends MiddleLink {
    private String separator = ".!?...";
    public SentencesParser()
    {
        this.next = null;
    }
    private boolean check(ArrayList<String> text)
    {
        boolean result = false;
        for (int i = 0; i <text.size() ; i++) {
            for (int j = 0; j <text.get(i).length(); j++) {
                if(separator.indexOf(text.get(i).charAt(j))!=-1)
                {
                    result = true;
                }
            }
        }
        return result;
    }
    @Override
    public ArrayList<String> parse(ArrayList<String> text) {
        if(!check(text))
        {
            return this.parseNext(text);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.get(i).length(); j++) {
                sb.append(text.get(i).charAt(j));
                if(separator.indexOf(text.get(i).charAt(j))!=-1)
                {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return this.parseNext(words);
    }
}
