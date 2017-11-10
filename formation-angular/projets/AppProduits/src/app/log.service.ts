export class LogService {
  log(message) {
    if (message instanceof Object)
      console.log(`OBJECT: ${JSON.stringify(message)}`)
    else
      console.log(`MESSAGE: '${message}'`)
  }
}
