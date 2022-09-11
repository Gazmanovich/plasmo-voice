package su.plo.voice.client.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class IconButton extends Button {

    private final ResourceLocation iconLocation;

    public IconButton(int x, int y, int width, int height, ResourceLocation iconLocation, OnPress onPress, OnTooltip onTooltip) {
        super(x, y, width, height, Component.empty(), onPress, onTooltip);
        this.iconLocation = iconLocation;
    }

    @Override
    public void renderButton(@NotNull PoseStack poseStack, int mouseX, int moseY, float delta) {
        super.renderButton(poseStack, mouseX, moseY, delta);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, iconLocation);

        RenderSystem.enableDepthTest();
        blit(poseStack, x + 2, y + 2, 0, 0, 16, 16, 16, 16);
    }
}
