const http = require('http')

const log = console.log.bind(console)

const initializationDuration = 1 * 1000
const processingDuration = 10 * 1000

let nbProcessingRequests = 0
let stopping = false
let nextRequestId = 1

log(`starting (not ready yet, will take ${(initializationDuration / 1000).toFixed(2)} seconds)...`)
setTimeout(() => {
    http.createServer((req, res) => {
        switch (req.url) {
            case "/health": {
                res.writeHead(200)
                res.end()
                break
            }

            case "/stop": {
                stopping = true
                log(`we are going to stop soon !`)

                res.writeHead(200)
                res.end()
                break
            }

            default: {
                nbProcessingRequests++
                let requestId = nextRequestId++
                log(`processing request ${requestId} (total processing: ${nbProcessingRequests}, stopping: ${stopping})`)
                setTimeout(() => {
                    nbProcessingRequests--
                    log(`finished process request ${requestId} (still processing: ${nbProcessingRequests}, stopping: ${stopping})`)
                    res.writeHead(200)
                    res.end()

                    if (stopping && !nbProcessingRequests) {
                        log(`that was the last request we process, bye !`)
                        process.exit(0)
                    }
                }, processingDuration)
                break
            }
        }
    }).listen(8080)

    log(`started, ready for incoming requests`)
}, initializationDuration)