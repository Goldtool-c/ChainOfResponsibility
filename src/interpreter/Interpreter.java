package interpreter;

public enum Interpreter {
    GENERAL;
    private String operator="^|&>><<~";
    private String parseBin(int a) {
        int i, b;
        StringBuilder sb = new StringBuilder();
        while(a !=0 ) {
            b = a%2;
            sb.append(b);
            a = a/2;
        }
        while (sb.toString().length()<8)
        {
            sb.append(0);
        }
        sb.reverse();
        System.out.println(sb.toString());
        return sb.toString();
    }
    private int binaryToInteger(String binary) {
        char[] numbers = binary.toCharArray();
        int result = 0;
        for(int i=numbers.length - 1; i>=0; i--)
            if(numbers[i]=='1')
                result += Math.pow(2, (numbers.length-i - 1));
        return result;
    }
    private int bitwiseAnd(String bin1, String bin2)
    {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < bin1.length() ; i++) {
            if(bin1.charAt(i)==bin2.charAt(i)&&bin1.charAt(i)=='1')
            {
                sb.append('1');
            } else
            {
                sb.append('0');
            }
        }
       return binaryToInteger(sb.toString());
    }
    private int bitwiseOr(String bin1, String bin2)
    {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < bin1.length() ; i++) {
            if(bin2.charAt(i)=='1'|| bin1.charAt(i)=='1')
            {
                sb.append('1');
            } else
            {
                sb.append('0');
            }
        }
        return binaryToInteger(sb.toString());
    }
    private int bitwiseExclusive(String bin1, String bin2)
    {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < bin1.length() ; i++) {
            if(bin1.charAt(i)!=bin2.charAt(i)&&(bin2.charAt(i)=='1'|| bin1.charAt(i)=='1'))
            {
                sb.append('1');
            } else
            {
                sb.append('0');
            }
        }
        return binaryToInteger(sb.toString());
    }
    private int bitwiseNot(String bin)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bin.length() ; i++) {
            if(bin.charAt(i)=='1')
            {
                sb.append('0');
            } else
            {
                sb.append('1');
            }
        }
        return binaryToInteger(sb.toString());
    }
    private int bitwiseLeftShift(String bin, String bit)
    {
        int bits = Integer.parseInt(bit);
    }
    public void count(String first, String second)
    {
        int a = Integer.parseInt(first);
        int b = Integer.parseInt(second);
        int res = bitwiseAnd(parseBin(a), parseBin(b));
        System.out.println(res);
    }
}
