import day12.CaveNetwork

fun main(args: Array<String>) {
    print(CaveNetwork(args.asList()).numberOfRoutes("start", "end"))
}