$(document).ready(function(){$.get("http://localhost:8020/state",function(t){for(var n in t){var e=t[n],a=new Date;a.setTime(e.date);var d=a.toLocaleDateString();$(".server-body").append("<tr><td>"+e.ip+"</td><td>"+(e.running?"Running":"Stopping")+"</td><td>"+d+"</td>/tr>")}})});