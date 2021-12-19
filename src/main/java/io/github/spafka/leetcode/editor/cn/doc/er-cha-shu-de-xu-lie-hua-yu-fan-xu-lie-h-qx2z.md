### 解题思路
C++ 后续遍历

### 代码

```cpp
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

vector<string> split(string& data)
    {
        vector<string> ans;
        istringstream ss(data);
        string temp;
        while (ss >> temp)
        {
            ans.push_back(temp);
        }
        return ans;
    }
    string serialize(TreeNode* root)
    {
        if (root == nullptr) return "#";
        string left = serialize(root->left);
        string right = serialize(root->right);
        return left + " " + right + " " + std::to_string(root->val);
    }
    TreeNode* de(vector<string>& nodes)
    {
        if (nodes.empty()) return nullptr;
        string rootString = nodes.back();
        nodes.pop_back();
        if (rootString == "#") return nullptr;
        int rootValue = atoi(rootString.c_str());
        TreeNode* root = new TreeNode(rootValue);
        root->right = de(nodes);
        root->left = de(nodes);
        return root;
    }
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data)
    {
        if (data.empty()) return nullptr;
        auto nodes = split(data);
        return de(nodes);
    }
};
// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));
```