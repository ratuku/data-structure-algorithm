package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * If G is an undirected graph, a vertex cover of G is a subset of
 * the nodes where every edge of G touches one of those nodes.
 * The vertex cover problem asks whether a graph contains
 * a vertex cover of a specified size k.
 */
public class VertexCoverProblem {

    /**
     *
     * SOLVER - tries to find a vertex cover of size <= n
     * Time complexity - Exponential O(2^k).
     * We don't know if we can get a polynomial solution
     * Tries all subsets of vertices to find a vertex cover of size k
     *
     * @param edges
     * @param cover
     * @param k
     * @return boolean
     */
    public static boolean hasVertexCover(List<int[]> edges,
                                         Set<Integer> cover, int k) {
        // Find the first uncovered edge
        int[] uncoveredEdge = null;
        for (int[] edge : edges) {
            if (!cover.contains(edge[0]) && !cover.contains(edge[1])) {
                uncoveredEdge = edge;
                break;
            }
        }

        // All edges are covered!
        if (uncoveredEdge == null) {
            System.out.println("Vertex cover found: " + cover);
            return true;
        }

        // Exceeded our budget of k nodes
        if (k == 0) return false;

        // Try adding the left endpoint
        cover.add(uncoveredEdge[0]);
        if (hasVertexCover(edges, cover, k - 1)) return true;
        cover.remove(uncoveredEdge[0]);

        // Try adding the right endpoint
        cover.add(uncoveredEdge[1]);
        if (hasVertexCover(edges, cover, k - 1)) return true;
        cover.remove(uncoveredEdge[1]);

        return false;
    }


    /**
     * NP problems have polynomial time verifier.
     * VERIFIER - Polynomial O(E)
     *
     * @param edges
     * @param cover
     * @return boolean
     */
    public static boolean isVertexCover(List<int[]> edges,
                                        Set<Integer> cover) {
        for (int[] edge : edges) {
            if (!cover.contains(edge[0]) && !cover.contains(edge[1])) {
                System.out.println("Edge (" + edge[0] + ","
                        + edge[1] + ") is not covered!");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example graph with 6 vertices and 8 edges
        // Edges: (0,1), (0,2), (1,3), (2,3), {1, 4},
        // {4, 5}, {3, 5}, {1, 5}
        //
        //   v0--v1--v4
        //   |    | \ |
        //   v2--v3--v5
        //
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{0, 2});
        edges.add(new int[]{1, 3});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{1, 4});
        edges.add(new int[]{4, 5});
        edges.add(new int[]{3, 5});
        edges.add(new int[]{1, 5});

        int k = 3;

        System.out.println("=== SOLVER ===");
        System.out.println("Looking for vertex cover of size <= " + k);
        Set<Integer> cover = new HashSet<>();
        if (hasVertexCover(edges, cover, k)) {
            System.out.println("Graph HAS a vertex cover of size <= " + k);
        } else {
            System.out.println("Graph does NOT have a vertex cover of size <= " + k);
        }

        System.out.println("\n=== VERIFIER ===");
        System.out.println("Verifying cover " + cover + ": "
                + isVertexCover(edges, cover));
    }


}
