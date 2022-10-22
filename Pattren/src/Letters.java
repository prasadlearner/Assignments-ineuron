
class Pattrens
{
    public static void main(String...args)
    {
        int n = 11;
        for(int i=0;i<n;i++)
        {
           for(int j=0;j<n;j++)
           {
            // for--D
            if(i==0 && j< (n-1) || i==(n-1) && j< (n-1) || j==0 || j==(n-1) && i !=0 && i< (n-1))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            
        //    for--U
           for(int j=0;j<n;j++)
           {
            if(j==0 && i !=(n-1) || j==(n-1) && i<(n-1) || i==(n-1) && j > 0 && j < (n-1))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }

        //   for--R 
           for(int j=0;j<n;j++)
           {
            if(i==0 && j<(3*n)/4 || i==(n-1)/2 && j< (3*n)/4 || j==0 || j==(3*n)/4 && i !=0 && i< (n-1)/2 || i==j && i>(n/2) && j>(n/2) )
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           } 

        //    for --G
           for(int j=0;j<n;j++)
           {
            if(i==0 && j>0 && j<=(3*n)/4 || j==0 && i>0 && i<(n-1) || i==(n-1) && j>0 && j<(n-1)/2 || j==(n-1)/2 && i>(n-1)/2 && i<(n-1) || i==(n-1)/2 && j>(n-1)/2  || j==(n-1) && i>(n-1)/2)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            // for--A

           for(int j=0;j<n;j++)
           {
            if(i==0 && j>0 && j<(n-1) || j==0 && i>0 || j==(n-1) && i>0 || i==(n-1)/2)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            //   for --P
           for(int j=0;j<n;j++)
           {
            if(i==0 && j<(n-1) || i==(n-1)/2 && j<(n-1) || j==0 || j==(n-1) && i!=0 && i<(n-1)/2)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            // for--R

           for(int j=0;j<n;j++)
           {
            if(i==0 && j<(3*n)/4 || i==(n-1)/2 && j< (3*n)/4 || j==0 || j==(3*n)/4 && i !=0 && i< (n-1)/2 || i==j && i>(n/2) && j>(n/2) )
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            //   for--A

           for(int j=0;j<n;j++)
           {
            if(i==0 && j>0 && j<(n-1) || j==0 && i>0 || j==(n-1) && i>0 || i==(n-1)/2)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            //    for--S

           for(int j=0;j<n;j++)
           {
            if(i==0 && j>0 && j<(n-1) || i==(n-1)/2 && j>0 && j<(n-1) || i==(n-1) && j>0 && j<(n-1) || j==0 && i>0 && i<(n-1)/2 || j==(n-1) && i>(n-1)/2 && i<(n-1))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }

        //   for--A  
           for(int j=0;j<n;j++)
           {
            if(i==0 && j>0 && j<(n-1) || j==0 && i>0 || j==(n-1) && i>0 || i==(n-1)/2)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
            
        //    for--D

           for(int j=0;j<n;j++)
           {
            if(i==0 && j< (n-1) || i==(n-1) && j< (n-1) || j==0 || j==(n-1) && i !=0 && i< (n-1))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
//           for--
           for(int j=0;j<n;j++)
           {
            if(i==n/2 && j>(n/4) && j<(3*n)/4)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           
//           for I
           
           for(int j=0;j<n;j++)
           {
            if(i==0 && j>(n/4) && j<(3*n)/4 || i==(n-1) && j>(n/4) && j<(3*n)/4 || j==(n/2))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           
//           for--N 
           for(int j=0;j<n;j++)
           {
            if(j==0 || j==(n-1) || i==j)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           
//           for--E
           for(int j=0;j<n;j++)
           {
            if(i==0 && j>(n/2) && j< (3*n)/4 || i==(n/2) && j>(n/2) && j<(3*n)/4 || i==(n-1) && j>(n/2) && j<(3*n)/4 || j==(n/2))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           
//           for--U
           for(int j=0;j<n;j++)
           {
            if(j==0 && i<(n-1) || j==(3*n)/4 && i<(n-1) || i==(n-1) && j>0 && j<(3*n)/4)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           
//           for--R
           for(int j=0;j<n;j++)
           {
            if(i==0 && j<(n-1)/2 || i==(n-1)/2 && j< (n-1)/2 || j==0 || j==(n-1)/2 && i !=0 && i< (n-1)/2 || j==(n-1)/2 && i >(n-1)/2  )
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
//           for--O
           for(int j=0;j<n;j++)
           {
            if(i==0 && j>0 && j<(3*n)/4 || i==(n-1) && j>0 && j<(3*n)/4 || j==0 && i>0 && i<(n-1) || j==(3*n)/4 && i>0 && i<(n-1))
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           
//           for--N
           for(int j=0;j<n;j++)
           {
            if(j==0 || j==(n-1) || i==j)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
           }
           System.out.println(" ");
        }
    }
}
