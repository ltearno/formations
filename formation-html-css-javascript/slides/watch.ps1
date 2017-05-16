Write-Host "Démarrage"

### SET FOLDER TO WATCH + FILES TO WATCH + SUBFOLDERS YES/NO
    $watcher = New-Object System.IO.FileSystemWatcher
    $watcher.Path = "."
    $watcher.Filter = "*.md"
    $watcher.IncludeSubdirectories = $false
    $watcher.EnableRaisingEvents = $true  

### DEFINE ACTIONS AFTER A EVENT IS DETECTED
    $action = { $path = $Event.SourceEventArgs.FullPath
                $changeType = $Event.SourceEventArgs.ChangeType
                $logline = "$(Get-Date), $changeType, $path"
                Add-content "D:\log.txt" -value $logline
              }
    $action2 = {
        Write-Host "Compiling"
        & .\commandes.bat
        Write-Host "Done"
    }
### DECIDE WHICH EVENTS SHOULD BE WATCHED + SET CHECK FREQUENCY  
    $created = Register-ObjectEvent $watcher "Created" -Action $action2
    $changed = Register-ObjectEvent $watcher "Changed" -Action $action2
    while ($true) {sleep 1}