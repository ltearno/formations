

openssl req -x509 -newkey rsa:4096 -keyout tls.key.pem -nodes -out tls.cert.pem -days 365

kubectl create secret tls test-tls --key="tls.key.pem" --cert="tls.cert.pem"