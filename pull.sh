#!/bin/bash

###########################################################################################
#
#	SCRIPT PARA PULL DE VARIOS REPOSITORIOS
#	Autor: Cedric Christoph
#	Version: 1.2
#	Importante! : Introducir las rutas a cada repositorio que se debe hacer pull
#		      en los elementos del array arr.
#
###########################################################################################


declare -a arr=("/home/dama/GitHub/AccesoADatosCedric" "/home/dama/GitHub/InterfacesCedric" "/home/dama/GitHub/multimedia")

contador=1

for i in "${arr[@]}"
do
	name=`echo "$i" | rev | cut -d '/' -f1 | rev`
	echo "=========================================="
	echo "Cargando repositorio $name... ( $contador / ${#arr[@]} ) "
	cd "$i" > /dev/null
	git pull > /dev/null
	contador=$((contador + 1))
	echo "=========================================="	
	echo ""
done
echo ""
echo "✔ Repositorios actualizados"
echo ""
echo "[ Presione ENTER para finalizar script ]"
read zero
