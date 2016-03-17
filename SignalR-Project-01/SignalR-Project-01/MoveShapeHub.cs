using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;
using Newtonsoft.Json;
namespace SignalR_Project_01
{
  public  class MoveShapeHub: Hub
    {
        public void UpdateModel(ShapeModel clienteModel) {
            clienteModel.LastUpdateBy = Context.ConnectionId;
            Clients.AllExcept(clienteModel.LastUpdateBy).updateShape(clienteModel);
        }

        public class ShapeModel {
            [JsonProperty("left")]
            public double Left { get; set; }

            [JsonProperty("top")]
            public double Top { get; set; }

            [JsonIgnore]
            public string LastUpdateBy { get; set; }

        }
    }
}
