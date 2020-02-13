

On déploie le même pod, mais avec un init container qui avec le compte de service approprié va récupérer la valuer du secret et la passe au container principal par un volume emptyDir

- volume emptyDir
- service account, role, rolebinding
- init containers