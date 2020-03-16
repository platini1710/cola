


function fetchAPI(){

	fetch('http://10.11.134.46:7001/pushJmsFonasa/rest/jms/consumeQueue/')
	  .then(
			    function(response) {
			      if (response.status !== 200) {
			        console.log('Looks like there was a problem. Status Code: ' +
			          response.status);
			        return;
			      }

			      // Examine the text in the response
			      response.json().then(function(data) {
			        console.log(data);
			      });
			    }
			  )
			  .catch(function(err) {
			    console.log('Fetch Error :-S', err);
			  });
	}

async function logFetch(url) {
	  try {
	    const response = await fetch(url);
	    if ((await response.text())=="ok") {
	    alert("respuesta enviada")
	  }
	   // console.log(await response.text());
	  }
	  catch (err) {
	    console.log('fetch failed', err);
	  }
	}


function timeout() {
	logFetch('http://10.11.134.46:7001/pushJmsFonasa/rest/jms/consumeQueue?user=augusto');
    setTimeout(function () {
        // Do Something Here
        // Then recall the parent function to
        // create a recursive loop.
        timeout();
    }, 30000);
}

timeout();

