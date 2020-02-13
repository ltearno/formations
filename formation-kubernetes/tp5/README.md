L'objectif est de déployer une ingress avec nos certificats TLS

openssl req -x509 -newkey rsa:2048 -keyout tls.key.pem -nodes -out tls.cert.pem -days 365

kubectl create secret tls test-tls --key="tls.key.pem" --cert="tls.cert.pem"

# liste des pods avec le label app=cassandra
kubectl get pods --selector=app=cassandra

# voir les labels des pods
kubectl get pods -o jsonpath='{.items[*].metadata.labels}'

for item in $( kubectl get pod --output=name); do printf "Labels for %s\n" "$item" | grep --color -E '[^/]+$' && kubectl get "$item" --output=json | jq -r -S '.metadata.labels | to_entries | .[] | " \(.key)=\(.value)"' 2>/dev/null; printf "\n"; done
