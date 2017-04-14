/**
 * Created by chenmuen on 2017/4/14.
 */
$(document).ready(function () {
   $.get("http://localhost:8020/state", function (msg) {
       for(var ip in msg) {
          var server = msg[ip];
          var date = new Date();
          date.setTime(server.date);
          var updateTime = date.toLocaleDateString();
          $(".server-body").append("" +
              "<tr>" +
              "<td>"+server.ip+"</td>" +
              "<td>"+(server.running?'Running':'Stopping')+"</td>" +
              "<td>"+updateTime+"</td>" +
              "/tr>");
       }
   });
});