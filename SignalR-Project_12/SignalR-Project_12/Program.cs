using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR.Client;


namespace SignalR_Project_12
{
    class Program
    {
        private static ConsoleColor[]
            _colors = new[] {
                ConsoleColor.Black, ConsoleColor.Red,ConsoleColor.Green,ConsoleColor.Blue,
                ConsoleColor.Yellow, ConsoleColor.Magenta,ConsoleColor.White
                             };

        static void Main(string[] args)
        {
            Console.Title = "Drawing Board Virtual";
            Console.SetWindowSize(80, 60);
            Console.BackgroundColor = ConsoleColor.White;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.Clear();

            var server = "http://localhost:58047/";
            var hubConn = new HubConnection(server);
            var hubProxy = hubConn.CreateHubProxy("board");

            hubProxy.On("clear", () =>
        { 
                 Console.BackgroundColor = ConsoleColor.White;
            Console.Clear();
        }
                );
            hubProxy.On("drawPoint", (int x, int y, int color) =>
            {
                DrawPoint(x, y, color);
            }
            );


            hubProxy.On("update", (int[,] buffer) =>
            {
                for (int x = 0; x < buffer.GetLength(0); x++)
                {
                    for (int y = 0; y < buffer.GetLength(1); y++)
                    {
                        if (buffer[x, y] != 0)
                        {
                            DrawPoint(x, y, buffer[x, y]);
                        }
                    }
                }
            }
            );
            hubConn.Start().ContinueWith(t =>
              {
                  if (t.IsFaulted)
                  {
                      Console.WriteLine("Error to Connecte");
                  }
              }
              
            );
            Console.ReadLine();
            hubConn.Stop();
        }

        private static void DrawPoint(int x, int y, int color)
        {
            int translatedx = Console.WindowWidth * x / 250;
            int translatedy = Console.WindowHeight * y / 250;
            Console.SetCursorPosition(translatedx, translatedy);
            Console.BackgroundColor = _colors[color - 1];
            Console.Write(" ");


        }
    }
}
