package parser;

import java.util.ArrayList;

public class TextParser extends MiddleLink {
    public TextParser()
    {
        this.next=new ParagraphParser();
    }
    @Override
    public ArrayList<String> parse(ArrayList<String> text) {
        String separator = "    ";
        boolean check = false;
        ArrayList<String> paragraphs=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <text.get(0).length() ; i++) {
            //Проверка на 4 пробела
            if(text.get(0).charAt(i)==' ')
            {
                int counter = 1;
                for (int j = 0; j < 3 ; j++) {
                    if(i+3>=text.get(0).length()) {break;}//Проверка, можно ли шагнуть еще на 3 символа вперед
                    if(text.get(0).charAt(i+j+1)==' ')
                    {
                        counter++;
                    }
                }
                if(counter==4)//При вхождении в этот блок предоставляется разрешение на передачу текста дальше по цепи
                {
                    check=true;
                    i=+3;
                    paragraphs.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {sb.append(text.get(0).charAt(i));}
        }
        if(check) {
            return this.parseNext(paragraphs);
        } else
        {
            return this.parseNext(text);
        }
    }
}
