package parser;

import java.util.ArrayList;

public class ParagraphParser extends MiddleLink {
    public ParagraphParser()
    {
        this.next= new SentencesParser();
    }
    private boolean check(ArrayList<String> text)
    {
        String separator = ".!?...";
        boolean result = false;
        for (int i = 0; i < text.size(); i++) {
            int counter = 0;
            for (int j = 0; j < text.get(i).length(); j++) {
                if(separator.indexOf(text.get(i).charAt(j))!=-1)
                {
                    counter++;
                }
            }
            if(counter==2)
            {
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public ArrayList<String> parse(ArrayList<String> text) {
       if(!this.check(text))
       {
           return this.parseNext(text);
       }
       ArrayList<String> sentences = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
       String separator = ".!?...";
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.get(i).length(); j++) {
                if(separator.indexOf(text.get(i).charAt(j))!=-1)
                {
                    sb.append(text.get(i).charAt(j));
                    sentences.add(sb.toString());
                    sb = new StringBuilder();
                } else
                {
                    sb.append(text.get(i).charAt(j));
                }
            }
        }
        return this.parseNext(sentences);
    }
}
