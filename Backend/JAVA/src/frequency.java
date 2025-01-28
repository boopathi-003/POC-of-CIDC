public class frequency {
    public static void main(String[] args) {
        String s="mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmvfddd";
        int visited=-1;
        int count=0;
        int []fre=new int[s.length()];
        char[]ch=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            fre[i]=1;
            for(int j=i+1;j<ch.length;j++)
            {
                if(ch[i]==ch[j] && ch[i]!=' ')
                {
                    fre[i]++;
                    ch[j]= (char) visited;
                }
            }

        }
        for(int k=0;k<fre.length;k++)
        {
            if(ch[k]!=(char)visited && ch[k]!=' '){
                System.out.println(ch[k]+"-"+fre[k]);
            }

        }
    }
}
