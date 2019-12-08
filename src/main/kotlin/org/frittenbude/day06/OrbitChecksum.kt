package org.frittenbude.day06


data class Orbit(val centerPlanet: String, val orbitingPlanet: String )

data class Planet(val name: String, var parent: Planet?) {
    private val orbitingPlanets = mutableListOf<Planet>()

    constructor(name: String) : this(name, null)

    fun addPlanetToOrbit(planet: Planet){
        planet.parent = this
        orbitingPlanets.add(planet)
    }

    fun getOrbitingPlanets() : List<Planet>{
        return orbitingPlanets.toList()
    }
}

class OrbitChecksum{
    fun calculateChecksum(orbits: List<Orbit>) : Int {
        return calculateChecksumForPlanet(buildTree(orbits), 0)
    }

    fun countOrbitalTransfers(orbits: List<Orbit>):Int{
        // find "YOU" in planet tree
        val tree = buildTree(orbits)
        val you = findPlanetByName("YOU", tree)
        return countTransfersToSanta(you!!.parent!!)
    }

    private fun countTransfersToSanta(_tree: Planet): Int{
        var tree = _tree
        var stepsUp = 0

        while(findPlanetByName("SAN", tree) == null){
            tree = tree.parent!!
            stepsUp++
        }

        // now go down until you reached SANTA :-)
        return stepsUp + depthOfChild("SAN", tree) - 1

    }

    private fun buildTree(orbits: List<Orbit>): Planet{
        val subPlanets = mutableListOf<Planet>()

        for(orbit in orbits){
            // there are four possible cases: A and B already exists | A exists and B does not | A does not exist but B does | A and B do both not exist yet
            var planetA = subPlanets.mapNotNull { findPlanetByName(orbit.centerPlanet, it) }.firstOrNull()
            if(planetA == null){
                planetA = Planet(orbit.centerPlanet)
                subPlanets.add(planetA)
            }

            // if B exist it must be a root
            var planetB = subPlanets.find{ it.name == orbit.orbitingPlanet}
            if(planetB != null) subPlanets.remove(planetB)
            else planetB = Planet(orbit.orbitingPlanet)

            planetA.addPlanetToOrbit(planetB)
        }

        return subPlanets.single()
    }

    private fun findPlanetByName(planetName: String, root: Planet): Planet?{
        if(root.name == planetName) return root
        if(root.getOrbitingPlanets().isEmpty()) return null
        return root.getOrbitingPlanets().map { findPlanetByName(planetName, it) }.find { it != null }
    }

    private fun depthOfChild(planetName: String, root: Planet): Int{
        if(root.name == planetName) return 0

        var planet = root
        var depth = 0
        while(planet.name != "SAN"){
            planet = planet.getOrbitingPlanets().single{findPlanetByName("SAN", it) != null}
            depth +=1
        }
        return depth
    }

    private fun calculateChecksumForPlanet(root: Planet, depth: Int): Int{
        if(root.getOrbitingPlanets().isEmpty()) return depth
        return depth + root.getOrbitingPlanets().map { calculateChecksumForPlanet(it, depth+1) }.sum()
    }
}