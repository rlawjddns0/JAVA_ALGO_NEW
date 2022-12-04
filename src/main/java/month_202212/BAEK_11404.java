package month_202212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BAEK_11404 {
    static int N;
    static int M;
    static int graph[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph=new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                graph[i][j]=Integer.MAX_VALUE;
                if(i==j)graph[i][j]=0;
            }
        }

        for(int i=0; i<M; i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to]=Math.min(graph[from][to],cost);
        }


        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(graph[j][i]==Integer.MAX_VALUE)continue;
                for(int k=1; k<=N; k++){
                    if(graph[i][k]==Integer.MAX_VALUE)continue;
                    graph[j][k]=Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(graph[i][j]>=Integer.MAX_VALUE)System.out.print("0"+" ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }




    }
}
