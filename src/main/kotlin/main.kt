import caves.CaveNetwork

fun main(args: Array<String>) {
    print(CaveNetwork(args.asList()).numberOfRoutes("start", "end"))
}