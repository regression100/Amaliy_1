var Countly = Countly || {};
Countly.q = Countly.q || [];

Countly.app_key = 'bb5e17be2093a7644afc24fd83c3f9479f3a2d59';
Countly.url = 'https://countly.deniz.co';

Countly.q.push(['track_sessions']);
Countly.q.push(['track_pageview']);
Countly.q.push(['track_errors']);

(function() {
   var cly = document.createElement('script'); cly.type = 'text/javascript';
   cly.async = true;
   cly.src = 'https://countly.deniz.co/sdk/web/countly.min.js';
   cly.onload = function(){Countly.init()};
   var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(cly, s);
})();
