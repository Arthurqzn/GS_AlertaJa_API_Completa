@echo off
cd /d "%~dp0"
if not exist .env copy .env.example .env
 echo Verifique a senha no arquivo .env antes de iniciar.
pause
docker compose up --build -d
pause
