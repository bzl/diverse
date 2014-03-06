@echo off
echo ===========================================================================
echo This batch file will upload tomato.trx in the current directory to
echo 192.168.11.1 during the router's bootup.
echo.
echo * Set your ethernet card's settings to:
echo      IP:      192.168.11.2
echo      Mask:    255.255.255.0
echo      Gateway: 192.168.11.1.
echo * Unplug the router's power cable.
echo.

echo Press Ctrl+C to abort or any other key to continue...
pause > nul

echo.
echo * Re-plug the router's power cable.
echo.
echo ===============================================================================
echo Waiting for the router... Press Ctrl+C to abort.
echo.

set FIND=%WINDIR%\command\find.exe 
if exist %FIND% goto PING
set FIND=%WINDIR%\system32\find.exe 
if exist %FIND% goto PING
set FIND=find

:PING
ping -n 1 -w 50 192.168.11.1 | %FIND% "TTL="
if errorlevel 1 goto PING

echo tftp -i 192.168.11.1 put tomato.trx
tftp -i 192.168.11.1 put tomato.trx
if errorlevel 1 goto PING

set FIND=

echo.
echo ===============================================================================
echo * WAIT for about 2 minutes while the firmware is being flashed.
echo * Reset your ethernet card's settings back to DHCP.
echo * The default router address will be at 192.168.1.1.
echo.

pause
