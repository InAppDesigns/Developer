#-*- coding: UTF-8 -*-
import subprocess


def main():
	
	#Aplicação simples em Python para automatizar Push's e Pull's para o GitHub.
	
	local = raw_input('Insira o endereço completo do seu Repositório local: ')
	commit = raw_input('Insira seu commit: ')
	remote = raw_input('Insira Repo remote: ')
	branch = raw_input('Insira branch remote: ')
	print 'Seu commit foi:'+commit
	subprocess.call("cd ~/{0}/ && git add . && git commit -m '{1}' && git push {2} {3}".format(local, commit, remote, branch), shell = True)

main()
